import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {

    public Rasterer() {




        // YOUR CODE HERE
    }

    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     *
     *     The grid of images must obey the following properties, where image in the
     *     grid is referred to as a "tile".
     *     <ul>
     *         <li>The tiles collected must cover the most longitudinal distance per pixel
     *         (LonDPP) possible, while still covering less than or equal to the amount of
     *         longitudinal distance per pixel in the query box for the user viewport size. </li>
     *         <li>Contains all tiles that intersect the query bounding box that fulfill the
     *         above condition.</li>
     *         <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     *     </ul>
     *
     * @param number Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     *
     * @return A map of results for the front end as specified: <br>
     * "render_grid"   : String[][], the files to display. <br>
     * "raster_ul_lon" : Number, the bounding upper left longitude of the rastered image. <br>
     * "raster_ul_lat" : Number, the bounding upper left latitude of the rastered image. <br>
     * "raster_lr_lon" : Number, the bounding lower right longitude of the rastered image. <br>
     * "raster_lr_lat" : Number, the bounding lower right latitude of the rastered image. <br>
     * "depth"         : Number, the depth of the nodes of the rastered image <br>
     * "query_success" : Boolean, whether the query was able to successfully complete; don't
     *                    forget to set this to true on success! <br>
     */


    private int count_zoom(int number){

          if(number==0){

              number=1;


          }

          int zoom=-1;
          int surpass=0;

          while(number!=0){

             if(surpass<=1&&(number&1)==1){

                surpass++;

             }

             number=number>>1;

             zoom++;

        }


        if(surpass>1){

            zoom++;

        }

        return zoom;

    }


    private double LonDPP(double leftbound,double rightbound,double w){


        return (-leftbound+rightbound)/w;


    }


    private boolean queryValitation(double lrlon,double ullon,

       double ullat, double lrlat ){


            if(lrlon<=ullon||ullat<=lrlat){

                    return false;
            }


            if((ullon>=-122.2119140625||lrlon<=-122.2998046875)
              ||(ullat<=37.82280243352756||lrlat>=37.892195547244356)){

                    return false;

            }

            return true;



    }

/*    private Map<String, Object> false_result(){




    }*/
    public Map<String, Object> getMapRaster(Map<String, Double> params) {
        // System.out.println(params);
        Map<String, Object> results = new HashMap<>();
        /*System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in "
                           + "your browser.");*/

        System.out.println(params);




        double ROOT_LRLON = -122.2119140625;
        double ROOT_ULLON = -122.2998046875;

        double ROOT_ULLAT = 37.892195547244356;
        double ROOT_LRLAT = 37.82280243352756;

        double WIDTH=-122.2119140625+122.2998046875;

        double lrlon=params.get("lrlon");
               //lrlon=(lrlon<=ROOT_LRLON)? lrlon:ROOT_LRLON;
        double ullon=params.get("ullon");
               //ullon=(ullon>=ROOT_ULLON)? ullon:ROOT_ULLON;
        double w=params.get("w");
        double h=params.get("h");
        double ullat=params.get("ullat");
               //ullat=(ullat<=ROOT_ULLAT)? ullat:ROOT_ULLAT;
        double lrlat=params.get("lrlat");
               //lrlat=(lrlat>=ROOT_LRLAT)? lrlat:ROOT_LRLAT;

        if(!queryValitation(lrlon,ullon, ullat, lrlat )){


            results.put("render_grid","d0_x0_y0.png");
            results.put("raster_ul_lon",-122.2998046875);
            results.put("raster_ul_lat",37.892195547244356);
            results.put("raster_lr_lon",-122.2119140625);
            results.put("raster_lr_lat",37.82280243352756);
            results.put("depth",0);
            results.put("query_success",false);


            return results;

        }



        double dividedNumber=w*(WIDTH)/(lrlon-ullon)/256;

        int zoom=count_zoom((int) Math.ceil(dividedNumber));

        if(zoom>7){

            zoom=7;
        }

        double londpf=(-122.2119140625+122.2998046875)/(Math.pow(2,zoom));
        double latdpf=(37.892195547244356-37.82280243352756)/(Math.pow(2,zoom));
        //double londpf=londpp*;

        int x_num_left=(int) ((ullon-ROOT_ULLON)/londpf);
            x_num_left=(x_num_left>=0)? x_num_left:0;
        int x_num_right=(int) ((lrlon-ROOT_ULLON)/londpf);
            x_num_right=(x_num_right<=(int) Math.pow(2,zoom)-1)? x_num_right:(int) (Math.pow(2,zoom)-1);

        int y_num_upper=(int) ((ROOT_ULLAT-ullat)/latdpf);
            y_num_upper=(y_num_upper>=0)? y_num_upper:0;
        int y_num_lower=(int) ((ROOT_ULLAT-lrlat)/latdpf);
            y_num_lower=(y_num_lower<=(int) Math.pow(2,zoom)-1)? y_num_lower:(int) (Math.pow(2,zoom)-1);

        int x_w=x_num_right-x_num_left+1;

        int y_w=-y_num_upper+y_num_lower+1;


        String[][] grid=new String[y_w][x_w];

        for(int i=0;i<y_w;i++){

            for(int j=0;j<x_w;j++){

                    grid[i][j]="d"+zoom+"_x"+(j+x_num_left)+"_y"+(i+y_num_upper)+".png";

            }


        }


        results.put("render_grid",grid);
        results.put("raster_ul_lon",ROOT_ULLON+x_num_left*londpf);
        results.put("raster_ul_lat",ROOT_ULLAT-y_num_upper*latdpf);
        results.put("raster_lr_lon",ROOT_ULLON+(x_num_right+1)*londpf);
        results.put("raster_lr_lat",ROOT_ULLAT-(y_num_lower+1)*latdpf);
        results.put("depth",zoom);
        results.put("query_success",true);

/*
        results.put("render_grid",grid);
        results.put("raster_ul_lon",ROOT_ULLON);
        results.put("raster_ul_lat",ROOT_ULLAT);
        results.put("raster_lr_lon",ROOT_ULLON);
        results.put("raster_lr_lat",ROOT_ULLAT);
        results.put("depth",zoom);
        results.put("query_success",true);*/

        System.out.println(results);

        return results;
    }

}

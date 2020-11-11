public class AList{

    int[] items;

    int size=0;


   public AList(){

         
         items=new int[100];


   }



  public void resize_expand(){



      int[] temp=new int[items.length*2];

      System.arraycopy(items,0,temp,0,size);

      items=temp;

  }




    public void resize_shrink(){



      int[] temp=new int[size*2];

      System.arraycopy(items,0,temp,0,size);

      items=temp;

  }


  //try to create an addfirst (was not mentioned in the videos)


  public void addFirst(int x){

         



  }

  public void addLast(int x){



  	 if(size==items.length){

              resize_expand();


  	 }

  		items[size]=x;

  		size=size+1;



  }


  public int getLast(){



      return items[size-1];



  }



  public int get(int index){

         return items[index];



  }

  public int removeLast(){


  	 /*if(items.length/size<4){

            resize_shrink();
     

  	 }*/

        int last=getLast();

  		items[size-1]=0;
        
        size=size-1;

        return last;
  }




}
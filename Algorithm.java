public class Algorithm {
   public static void insertion_sort(int a[],int n){
       for(int i=1;i<n;i++)
       {
           int key=a[i];
           int j=i-1;
           while(j>=0 && a[j]>key)
           {
               a[j+1]=a[j];
               j=j-1;
           }
           a[j+1]=key;
       }
   }
   public static void print(int a[],int n){
       for(int i=0; i<n; i++)
           System.out.print(a[i]+" ");
       System.out.println("");
   }
   private static int partition(int a[],int l,int h){
     int  i=l;
     int  j=h;
     int  p=a[l];
     while(i<j)
     {
         do
         {
             i++;
         }while(i<h && a[i]<=p);
         do
         {
             j--;
         }while(j>l && a[j]>p);
         if(i<j){
             int x=a[i];
             a[i]=a[j];
             a[j]=x;
         } 
     }
          int x=a[l];
          a[l]=a[j];
          a[j]=x;
     return j;      
   }
   public static void quick_sort(int a[],int l,int h){
       if(l<h){
           int piv=partition(a,l,h);
           quick_sort(a,l,piv);
           quick_sort(a,piv+1,h);
       }
       
   }
   private static void merge(int a[],int l,int m,int r){
       int i,j,k;
       int n1=m-l+1;
       int n2=r-m;
       int L[]=new int[n1];
       int R[]=new int[n2];
       for(i=0;i<n1;i++)
           L[i]=a[l+i]; 
       for(j=0;j<n2;j++)   //(i;i<n2;i++)
           R[j]=a[m+1+j];
       i=j=0;
       k=l;
       while(i<n1 && j<n2){
           if(L[i]<=R[j]){
               a[k]=L[i];
               i++;
           }
           else{
               a[k]=R[j];
               j++;
           }
               k++;  
       }
       while(i<n1){
           a[k]=L[i];
           i++;
           k++;
       }
       while(j<n2){
           a[k]=R[j];
           j++;
           k++;
       }
           
   }
   public static void merge_sort(int a[],int l,int r){
       if(l<r){
           int m=l+(r-l)/2;
           merge_sort(a,l,m);
           merge_sort(a,m+1,r);
           merge(a,l,m,r);
                   
       }
   }
   public static void bubble_sort(int a[],int n){
       for(int i=0;i<n-1;i++)
       {
           for(int j=0;j<n-i-1;j++)
           {
               if(a[j]>a[j+1])
               {
                   int x=a[j];
                   a[j]=a[j+1];
                   a[j+1]=x;
               }
           }
       }
   }
   public static void selection_sort(int a[],int n){
       for(int i=n-1;i>0;i--)
       {
          int pos=0;
          for(int j=1;j<=i;j++)
          {
             if(a[j]>a[pos])
             {  
               pos=j;
             }
          }
          int x=a[i];
          a[i]=a[pos];
          a[pos]=x; 
       }
   }
   private static void heapfy(int a[],int n,int i)
   {
       int l=i*2+1;
       int r=i*2+2;
       int max=i;
       if(l<n && a[l]>a[max])
          max=l;
       if(r<n && a[r]>a[max])
           max=r;
       if(max!=i)
       {
          int x=a[i];
          a[i]=a[max];
          a[max]=x;
          heapfy(a,n,max);
       }
   }
   private static void build_heap(int a[],int n)
   {
       for(int i=n/2-1;i>=0;i--)
           heapfy(a,n,i);
   }
   public static void heap_sort(int a[],int n)
   {
       build_heap(a,n);
       for(int i=n-1;i>=0;i--)
       {
          int x=a[0];
          a[0]=a[i];
          a[i]=x;
          heapfy(a,i,0);
       }
   }
   public static int binarry_search(int a[],int l,int h,int key)
   {
     int m=(h+l)/2;
     if(h<l)
         return -1;
     else if(a[m]==key)
         return m;
     else if(a[m]>key)
        return binarry_search(a,l,m-1,key);
     else
         return binarry_search(a,m+1,h,key);       
   }
}

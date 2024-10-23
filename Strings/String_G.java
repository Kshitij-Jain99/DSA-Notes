public class String_G {

    public static float getShortestPath(String path) {  // int is final displacement
        int x=0, y=0;   

        for(int i=0; i<path.length(); i++) {
            char dir = path.charAt(i);   //analysing direction
            //south
            if(dir == 'S') {
                y--;
            }
            //north
            else if(dir =='N'){
                y++;
            }
            //west
            else if(dir == 'W') {
                x--;
            }
            //east
            else{
                x++;
            }

        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2+Y2);     //this function will return double value which needed to be typecasted to float(not int) to get accurate result
    }   
    
    public static void main(String args[]){
        String path =  "NS";                   //"WNEENESENNN";
        System.out.println(getShortestPath(path));
    }
    
}

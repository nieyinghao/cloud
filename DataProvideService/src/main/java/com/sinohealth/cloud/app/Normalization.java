package com.sinohealth.cloud.app;

public class Normalization {  
    public static void main(String[] args) {  
        double[] p1 = {1, 1};  
        double[] p2 = {1, 1};  
        Normalization n = new Normalization();  
        
        double result = n.getNormalizeDistance(p1, p2);  
        System.out.println("Normalization result is " + result);  
    }  
      
    /** 
     * @param point1 first point 
     * @param point2 second point 
     * @return the  normalization distance of two points 
     */  
    public double getNormalizeDistance(double[] point1, double[] point2) {  
        return 1 / (getDistance(point1, point2) + 1);  
    }  
      
    public double getDistance (double[] point1, double[] point2) {  
        double distance = 0;  
        for(int i=0; i<point1.length; i++) {  
            distance = distance + Math.pow(point1[i]-point2[i], 2);  
        }         
        return Math.pow(distance, 0.5);  
          
    }  
}  

/*
** An array contains red and green balls in random order. Write a possibly fast method to rearrange the array,
** so that all red balls are at the beginning and all green balls are at the end of the array. Consider the case
** when all balls have the same color.
*/

public class Balls {
   enum Color {green, red};
   private static Color[] _balls;
   
   public static void main (String[] param) {
      // for debugging
      _balls = new Color[]{Color.green, Color.red, Color.green, Color.red, Color.green, Color.red};
      reorder(_balls);
   }
   
   public static void reorder (Color[] balls) {
      int len = balls.length;
      int first = 0;
      int last = len - 1;

      while (first < last) {
         Color fItem = balls[first];
         Color lItem = balls[last];
         if (fItem != Color.red){
            while (last > first && lItem == Color.green) {
               last--;
               lItem = balls[last];
            }
            if (fItem != lItem) {
               balls[last] = Color.green;
               balls[first] = Color.red;
            }
         }
         first++;
      }
   }
}


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
      int len = balls.length; // Getting array length
      int first = 0;          // First item index
      int last = len - 1;     // Last item index

      while (first < last) {
         Color fItem = balls[first];   // First item value
         Color lItem = balls[last];    // Last item value
         /* If first item is not red go and do stuff */
         if (fItem != Color.red){
            /* Loop while last index > first index AND last item is green */
            while (last > first && lItem == Color.green) {
               last--;              // Decrease last item index
               lItem = balls[last]; // Assign new value to last item
            }
            /* If first item is not the same as last item, switch colors */
            if (fItem != lItem) {
               balls[last] = Color.green;
               balls[first] = Color.red;
            }
         }
         first++; // Increase first itme index
      }
   }
}


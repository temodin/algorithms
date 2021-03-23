import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class main {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    List<Integer> colors = new ArrayList<>();
    int socks = 0;
    int colourCounter = 0;
    for (int i = 0; i < n; i++) {
      //check if ar[i] is in colors
      colourCounter = 0;
      if (!colors.contains(ar[i])) {
        //if no, iterate through the list and count the occurences
        colors.add(ar[i]);
        for (int j = 0; j < n; j++) {
          if (ar[j] == ar[i]) {
            colourCounter++;
          }
        }
      }
      socks += (int) (colourCounter / 2);
    }
    //divide it by 2 without rest
    return socks;
  }

  static int sockMerchant2(int n, int[] ar) {
    HashMap<Integer, Integer> sockMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Integer j = sockMap.get(ar[i]);
      sockMap.put(ar[i], (j == null) ? 1 : j + 1);
    }

    int pairs = 0;
    for (Integer colour : sockMap.keySet()) {
      pairs += (int) (sockMap.get(colour) / 2);
    }

    return pairs;
  }

  public static int countingValleys(int steps, String path) {
    int Ucount = 0;
    int Dcount = 0;
    int valleyCount = 0;
    if ((path.charAt(0) == 'U')) {
      ++Ucount;
    } else {
      ++Dcount;
    }
    for (int i = 1; i < steps; i++) {
      if ((path.charAt(i) == 'U')) {
        ++Ucount;
      } else {
        ++Dcount;
      }
      if (Ucount == Dcount && path.charAt(i) == 'U') {
        valleyCount++;
      }
    }
return valleyCount;
  }

  static int jumpingOnClouds(int[] c) {
    int jumps = 0;
    int nextCloud = 0;
    for (int i=0; i < c.length-1;i++) {
      if (i == nextCloud) {
        if( (i+2) >= c.length || c[i+2] == 1) {
          nextCloud = i+1;
        } else nextCloud = i+2;
        jumps++;
      }
    }
    return jumps;
  }

  public static double evaluateReversePolish(String expr) {
    if (expr.equals("")) {
      return 0;
    }
    Stack<Double> stack = new Stack<>();
    String[] exprArr =expr.split(" ");
    for (int i = 0; i < exprArr.length;i++) {
      if (exprArr[i].equals("+")) {
        stack.push(stack.pop() + stack.pop());
      }
      else if (exprArr[i].equals("-")) {
        stack.push(-stack.pop() + stack.pop());
      }
      else if (exprArr[i].equals("*")) {
        stack.push(stack.pop() * stack.pop());
      }
      else if (exprArr[i].equals("/")) {
        stack.push((1/stack.pop()) / (1/stack.pop()));
      }
      else stack.push( Double.parseDouble(exprArr[i]));
    }
    return stack.peek();
  }

  public static void main(String[] args) {
//    int[] mySocks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
//    System.out.println(sockMerchant2(9, mySocks));
//    System.out.println(countingValleys(12,"UDDDUDUUDDUU"));
    int[] clouds = {0, 0, 0, 1, 0, 0};
    System.out.println(jumpingOnClouds(clouds));


  }
}

import java.lang.*;
import java.util.*;
public class Radix extends SortableLinkedList{
  public static int nth(int n, int col){
    if(Math.pow(10, col) - n > 0){
      return 0;
    }
    else{
      int val = n / (int) Math.pow(10, col);
      return val % 10;
    }
  }

  public static int length(int n){
    String str = "" + n;
    return str.length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static int digits(int n){
    return (int)(Math.log10(n) + 1);
  }

  public static void radixSortSimple(SortableLinkedList data){
    if(data.size() == 0){
      return;
    }
    SortableLinkedList master = data;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int maxDigits = digits(data.get(0));
    for(int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }
    for(int element = 0; element < data.size(); element++){//first pass - ones and maxDigits
      for(int bNum = 0; bNum < 10; bNum++){
        if(digits(data.get(element)) > maxDigits){
          maxDigits = digits(data.get(element));
        }
        if(nth(data.get(element), 0) == bNum){
          buckets[bNum].add(data.get(element));
          break;
        }
      }
    }
    while(data.size() > 0){
      data.remove(0);
    }
    merge(data, buckets);
    if(maxDigits < 2){
      return;
    }
    //up is ok
    for(int dig = 1; dig < maxDigits; dig++){
      for(int i = 0; i < data.size(); i++){
        for(int j = 0; j < 10; j++){
          if(digits(data.get(i)) > maxDigits){
          }
          if(nth(data.get(i), dig) == j){
            buckets[j].add(data.get(i));
            break;
          }
        }
      }
      while(data.size() > 0){
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    return;
  }

  public static void main(String[] args){
    SortableLinkedList newG = new SortableLinkedList();
    int[] newA = new int[10];
    for(int i = 0; i < 10; i++){
      int guy = (int)(Math.random() * 1000);
      newG.add(guy);
      newA[i] = guy;
    }
  }

}

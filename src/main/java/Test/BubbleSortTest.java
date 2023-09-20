package Test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    public static int[] array={2,13,12,4,12,4,14,1,4};
    @Test
    public void method1(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((array[i]>array[j])) {
                    int temp;
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        Assert.assertArrayEquals(new int[]{14,13,12,12,4,4,4,2,1},array);
    }
}

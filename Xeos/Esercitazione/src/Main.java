import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\n> Moneky Trouble");
		
		System.out.println(Test.monkeyTrouble(true, true));
		System.out.println(Test.monkeyTrouble(false, false));
		System.out.println(Test.monkeyTrouble(true, false));
		
		System.out.println("\n> Start oz");
		
		System.out.println(Test.startOz("ozymandias"));
		System.out.println(Test.startOz("bzoo"));
		System.out.println(Test.startOz("oxx"));
		
		System.out.println("\n> last 2");
		
		System.out.println(Test.last2("hixxhi"));
		System.out.println(Test.last2("xaxxaxaxx"));
		System.out.println(Test.last2("axxxaaxx"));
		System.out.println(Test.last2("bababbbnnbaba"));
		
		System.out.println("\n> Array Front");
		
		System.out.println(Test.arrayFront9(new int[]{1, 2, 9, 3, 4}));
		System.out.println(Test.arrayFront9(new int[]{1, 2, 3, 4, 9}));
		System.out.println(Test.arrayFront9(new int[]{1, 2, 3, 4, 5}));
		
		System.out.println("\n> See Color");
		
		System.out.println(Test.seeColor("redxx"));
		System.out.println(Test.seeColor("xxred"));
		System.out.println(Test.seeColor("blueTimes"));
		
		System.out.println("\n> Non start");
		
		System.out.println(Test.nonStart("Hello", "There"));
		System.out.println(Test.nonStart("java", "code"));
		System.out.println(Test.nonStart("shotl", "java"));
		
		System.out.println("\n> Reverse 3");
		
		System.out.println(Arrays.toString(Test.reverse3(new int[]{1, 2, 3})));
		System.out.println(Arrays.toString(Test.reverse3(new int[]{5, 11, 9})));
		System.out.println(Arrays.toString(Test.reverse3(new int[]{7, 0, 0})));
		
		System.out.println("\n> Unlucky 1");
		
		System.out.println(Test.unlucky1(new int[] {1, 3, 4, 5}));
		System.out.println(Test.unlucky1(new int[] {2, 1, 3, 4, 5}));
		System.out.println(Test.unlucky1(new int[] {1, 1, 1}));
		
		System.out.println("\n> Love 6");
		
		System.out.println(Test.love6(6, 4));
		System.out.println(Test.love6(4, 5));
		System.out.println(Test.love6(1, 5));
		
		System.out.println("\n> Sum Limit");
		
		System.out.println(Test.sumLimit(2, 3));
		System.out.println(Test.sumLimit(8, 3));
		System.out.println(Test.sumLimit(8, 1));
		
		System.out.println("\n> Lucky Sum");
		
		System.out.println(Test.luckySum(1, 2, 3));
		System.out.println(Test.luckySum(1, 2, 13));
		System.out.println(Test.luckySum(1, 13, 3));
		
		System.out.println("\n> Evenly Spaced");
		
		System.out.println(Test.evenlySpaced(0, 0, 0));
	}
}
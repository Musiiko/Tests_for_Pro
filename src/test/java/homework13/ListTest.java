package homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ListTest {
    List<Integer> actualList;
    ArrayList<Integer> expectedList;

    @BeforeEach
    void initArrays() {
        actualList = new List<>();
        expectedList = new ArrayList<>();

        actualList.elementToTheEndList(0);
        actualList.elementToTheEndList(2);
        actualList.elementToTheEndList(4);
        actualList.elementToTheEndList(6);
        actualList.elementToTheEndList(8);
        actualList.elementToTheEndList(10);

        expectedList.add(0);
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(8);
        expectedList.add(10);
    }


    @Test
    void whenTryingElementToTheBegin() {
        actualList.elementToTheBeginList(1111);
        expectedList.add(0, 1111);
        checkTheCase();
    }

    @Test
    void whenTryingToElementToTheEnd() {
        actualList.elementToTheEndList(2222);
        expectedList.add(2222);
        checkTheCase();
    }

    @Test
    void whenTryingToElementByIndex() {
        actualList.elementByIndex(12345, 5);
        expectedList.add(5, 12345);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteElementByIndex() {
        actualList.deleteElementByIndex(4);
        expectedList.remove(4);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteFirstElement() {
        actualList.deleteFirstElement();
        expectedList.remove(0);
        checkTheCase();
    }

    @Test
    void whenTryingToDeleteLastElement() {
        actualList.deleteLastElement();
        expectedList.remove(expectedList.size() - 1);
        checkTheCase();
    }

    @Test
    void whenTryToGetLengthOfList() {
        Assertions.assertEquals(expectedList.size(), actualList.getLength());
    }

    @Test
    void whenCheckIfIsEmpty() {
        Assertions.assertFalse(actualList.isEmptyList());
        while (actualList.getLength() != 0) {
            actualList.deleteLastElement();
        }
        Assertions.assertTrue(actualList.isEmptyList());
    }

    @Test
    void whenTryingToDeleteAllElementsInLoop() {
        while (actualList.getLength() != 0) {
            actualList.deleteFirstElement();
        }
        Assertions.assertTrue(actualList.isEmptyList());
    }

    @Test
    void whenInitFromArray() {
        Integer[] tempArray = new Integer[]{0, 2, 4, 6, 8, 10};
        List<Integer> List = new List<Integer>(tempArray);
        ArrayList<Integer> tempArrayList = new ArrayList<>(Arrays.asList(tempArray));

        Assertions.assertEquals(tempArrayList.toString(), List.toString());
    }

    @Test
    void whenTryingToInitEmptyList() {
        List<String> List = new List<>();
        ArrayList<String> myArrayList = new ArrayList<>();
        Assertions.assertEquals(myArrayList.toString(), List.toString());
    }

    @Test
    void whenTestingInverseOrSwap() {
        Collections.swap(expectedList, 1, 3);
        actualList.inverseElements(1, 3);
        checkTheCase();
    }

    private void checkTheCase() {
        Assertions.assertEquals(expectedList.toString(), actualList.toString());
    }
}
package br.com.bulvee.ld;

import br.com.bulvee.ld.util.Mock;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


class LinkedListTest {

    private LinkedList<Stock> linkedList;
    private Mock mock;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        mock = new Mock();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenItems_whenAddFirst_ValidPosition_thenVerify(TestInfo testInfo) {
        System.out.println("displayName = " + testInfo.getDisplayName());
        linkedList.addFirst(mock.petr4);
        linkedList.addFirst(mock.b3sa3);
        linkedList.addFirst(mock.bbas3);
        linkedList.addFirst(mock.vale3);

        System.out.println(linkedList);
        Stock vale3 = mock.vale3;
        assertTrue(validPositionFisrt(vale3));

    }


    @Test
    void givenItems_whenAddLast_ValidPosition_thenVerify(TestInfo testInfo) {
        System.out.println("displayName = " + testInfo.getDisplayName());
        linkedList.addFirst(mock.b3sa3);
        linkedList.addFirst(mock.bbas3);
        linkedList.addFirst(mock.vale3);
        //LastItem
        linkedList.addLast(mock.petr4);

        System.out.println(linkedList);
        assertTrue(validPositionLast(mock.petr4));

    }

    @Test
    void givenIndex_whenGetInvalidIndex_thenVerify(TestInfo testInfo) {
        System.out.println("displayName = " + testInfo.getDisplayName());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            linkedList.get(1000);
        });
    }

    @Test
    void givenIndex_whenAddAtMiddle_thenVerify(TestInfo testInfo) {
        System.out.println("displayName = " + testInfo.getDisplayName());

        linkedList.addFirst(mock.b3sa3);
        linkedList.addFirst(mock.bbas3);
        linkedList.addFirst(mock.vale3);


        Stock atMiddle = mock.irbr3;
        int index = 1;
        linkedList.add(index, atMiddle);

        System.out.println(linkedList);
        assertTrue(isAtIndex(index,  atMiddle));
    }

    @Test
    void givenItens_whenAdd_checkSize_thenVerify(TestInfo testInfo) {
        System.out.println("displayName = " + testInfo.getDisplayName());

        linkedList.addFirst(mock.b3sa3);
        linkedList.addFirst(mock.bbas3);
        linkedList.addFirst(mock.vale3);

        assertTrue(isSize(3));

    }

    private boolean isSize(int index) {
        return linkedList.size() == index;
    }

    private boolean isAtIndex(int i, Object item) {
        Stock stock = linkedList.get(1);
        return  stock.equals(item);
    }

    private boolean validPositionFisrt(Stock item) {
        Stock firstItem = linkedList.get(0);

        return firstItem.equals(item);
    }

    private boolean validPositionLast(Object item) {
        Stock lastItem = linkedList.get(linkedList.size() - 1);

        return lastItem.equals(item);
    }

}
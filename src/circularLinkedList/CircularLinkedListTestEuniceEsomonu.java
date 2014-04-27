package circularLinkedList;
import static org.junit.Assert.*;

import org.junit.Test;


public class CircularLinkedListTestEuniceEsomonu {
	/** Test to see that the initial list is empty */
	@Test
	public void test1() {
		 CircularLinkedList testInstance = new CircularLinkedList();
		assertEquals(true,testInstance.isEmpty());
	}
	/** Test to see that the initial list is empty */
	@Test
	public void test2(){
		CircularLinkedList testInstance = new CircularLinkedList();
		assertEquals(0,testInstance.size());
	}

    /**
     * Test to see that the get method throws an
     * exception on an empty list
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void test3() {
        CircularLinkedList testInstance = new CircularLinkedList();
        assertNull(testInstance.get(0));
    }

    /** Test to see that add method inserts an item */
   
    @Test
    public void test4() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pig");
        assertEquals(1, testInstance.size());
        assertEquals("pig", testInstance.toString());
    }

    /** Test to see that add method inserts three items */
    @Test
    public void test5() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add("ants");
        testInstance.add("platypus");
        assertEquals(3, testInstance.size());
        assertEquals("pigs ==> ants ==> platypus", testInstance.toString());
    }
   
    /** Test the get method on a list of three items */
    @Test
    public void test6() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add("ants");
        testInstance.add("platypus");
        assertEquals("pigs", testInstance.get(0));
        assertEquals("ants", testInstance.get(1));
        assertEquals("platypus", testInstance.get(2));
    }
 /** Test the add method to see if it adds in the middle */
    
    @Test
    public void test7() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add("ants");
        testInstance.add(1, "platypus");
        testInstance.add("tigers");
        assertEquals(4, testInstance.size());
        assertEquals("pigs ==> platypus ==> ants ==> tigers",
                testInstance.toString());
    }
    
    /** Test the add method to see if it adds in the middle */
       @Test
    public void test8() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add("ants");
        testInstance.add(1, "platypus");
        testInstance.add("tigers");
        assertEquals(4, testInstance.size());
        assertEquals("pigs ==> platypus ==> ants ==> tigers",
                testInstance.toString());
    }
    /** Test the add method to see if it adds in the middle */
    
    @Test
    public void test9() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add("ants");
        testInstance.add("platypus");
        testInstance.add(2, "tigers");
        assertEquals(4, testInstance.size());
        assertEquals("pigs ==> ants ==> tigers ==> platypus",
                testInstance.toString());
    }
    
    
    /** Test the add method to see if it adds in the front */
        @Test
    public void test10() {
        CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        testInstance.add("pigs");
        testInstance.add(0,"ants");
        testInstance.add("platypus");
        testInstance.add("tigers");
        assertEquals(4, testInstance.size());
        assertEquals("ants ==> pigs ==> platypus ==> tigers",
                testInstance.toString());
    }
        /** Test the add method to see if it adds at the end */
        
        @Test
        public void test11() {
            CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
            testInstance.add("pigs");
            testInstance.add("ants");
            testInstance.add("platypus");
            testInstance.add(3, "tigers");
            assertEquals(4, testInstance.size());
            assertEquals("pigs ==> ants ==> platypus ==> tigers",
                    testInstance.toString());
        }
        // Test the remove(item) method on an empty list 
        @Test
        public void test12() {
            CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
          assertFalse(testInstance.remove("pigs"));
        }
     // Test the remove method on a list with only one item 
        @Test(expected = IndexOutOfBoundsException.class)
        public void test13() {
        	 CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
        	 testInstance.add("pigs");
        	 assertEquals("pigs", testInstance.remove(0));
        }

        // Test the remove method by removing the first item 
        @Test(expected = IndexOutOfBoundsException.class)
        public void test14() {
        	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
       	 	testInstance.add("pigs");
       	 	testInstance.add("ants");
       	 	assertEquals("pigs", testInstance.remove(0));
        }
     // Test the remove method by removing the last item 
        @Test
        public void test15() {
        	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
       	 	testInstance.add("pigs");
       	 	testInstance.add("ants");
       	 	testInstance.add("platypus");
       	 	assertEquals("ants", testInstance.remove(1));
        }
     // Test the remove method by removing the last item 
        @Test
        public void test16() {
        	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
       	 	testInstance.add("pigs");
       	 	testInstance.add("ants");
       	 	testInstance.add("platypus");
       	 	assertEquals("platypus", testInstance.remove(2));
        }

       
        // Test the remove(item) method on a list with one item 
        @Test
        public void test17() {
        	CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
       	 	testInstance.add("pigs");
       	 	assertEquals(true, testInstance.remove("pigs"));
        }

        // Test the remove(item) from the first item of a list 
        @Test
        public void test18() {
        	 CircularLinkedList<String> testInstance = new  CircularLinkedList<String>();
             testInstance.add("pigs");
              testInstance.add("ants");
              assertEquals(true, testInstance.remove("pigs"));
              
        }
       

        // Test the remove(item) from the second item of a list 
        @Test
        public void test19() {
        	 CircularLinkedList<String> testInstance = new  CircularLinkedList<String>();
             testInstance.add("pigs");
              testInstance.add("ants");
        	assertEquals(true, testInstance.remove("ants"));
        }

        // Test the remove(item) from the third item of a list 
        @Test
        public void test20() {
        	 CircularLinkedList<String> testInstance = new  CircularLinkedList<String>();
             testInstance.add("pigs");
              testInstance.add("ants");
             testInstance.add("platypus");
             testInstance.add("tigers");
             assertEquals(true, testInstance.remove("platypus"));
        }

        // Test the remove(item) from the last item of a list 
        @Test
        public void test21() {
        	
        	 CircularLinkedList<String> testInstance = new  CircularLinkedList<String>();
             testInstance.add("pigs");
              testInstance.add("ants");
             testInstance.add("platypus");
             testInstance.add("tigers");
             assertEquals(true, testInstance.remove("tigers"));
        }
        
      /**
       * I created a test files that will test and everything. It will test the add method,the get method, size,
       * and the remove method. 
       */
       @Test(expected = IndexOutOfBoundsException.class)
       public void test22(){ 
            CircularLinkedList<String> testInstance = new CircularLinkedList<String>();
           testInstance.add("E");
            testInstance.add("u");
            testInstance.add( "i");
             testInstance.add(2, "n");
             testInstance.add("c");
             testInstance.add("e");
             
             assertEquals("My name!","E ==> u ==> n ==> i ==> c ==> e",testInstance.toString());
             
             assertEquals("i", testInstance.get(3));
             assertEquals("e", testInstance.get(5));
             
             assertEquals(6, testInstance.size());
             
             testInstance.remove(0);
             testInstance.remove(1);
             
             assertEquals("Nick name!", "n ==> i ==> c ==> e", testInstance.toString());
             
             assertEquals(4, testInstance.size());
        
            
            
            
       }

}

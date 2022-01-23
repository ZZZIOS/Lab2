package ru.spbstu.telematics.java;

import junit.framework.TestSuite;
import org.junit.*;
//import ru.spbstu.telematics.java.MyStack;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class MyStackTest
        extends TestSuite
{
    private Stack<Integer> javaStack;
    private MyStack<Integer> myStack;

    private<T> Boolean CollectionsEqual(Collection<T> c1, Collection<T> c2 ){
        if (c1==null&&c2==null)
            return true;
        if (c1==null)
            return false;
        return c1.equals(c2);
    }

    @Before
    public void SetUp(){
        javaStack = new Stack<Integer>();
        myStack = new MyStack<Integer>();
        javaStack.push(1);
        javaStack.push(2);
        javaStack.push(4);
        javaStack.push(7);
        javaStack.push(8);

        myStack.push(1);
        myStack.push(2);
        myStack.push(4);
        myStack.push(7);
        myStack.push(8);

    }

    @Test
    public void TestPush(){
        javaStack.push(10);
        myStack.push(10);
        Assert.assertEquals(myStack.toString(), javaStack.toString());
    }

    @Test
    public void TestSearch(){
        Assert.assertEquals(myStack.search(1), javaStack.search(1));
        Assert.assertEquals(myStack.search(null), javaStack.search(null));
    }


    @Test
    public void TestPop(){
        Assert.assertEquals(javaStack.pop(),myStack.pop());
        Assert.assertEquals(myStack.toString(), javaStack.toString());
    }

    @Test
    public void TestPeek(){
        Assert.assertEquals(javaStack.peek(),myStack.peek());
        Assert.assertEquals(myStack.toString(), javaStack.toString());
    }


    @Test
    public void TestEmpty(){
        Assert.assertEquals(javaStack.empty(),myStack.empty());
        javaStack.clear();
        myStack.clear();
        Assert.assertEquals(javaStack.empty(),myStack.empty());
    }

    @Test
    public void TestIterator(){
        Iterator<Integer> myIterator= myStack.iterator();
        Iterator<Integer> javaIterator = javaStack.iterator();

        Assert.assertEquals( myIterator.hasNext(), javaIterator.hasNext());

        while (myIterator.hasNext() && javaIterator.hasNext())
            Assert.assertEquals(myIterator.next(), javaIterator.next());

        Assert.assertEquals(myIterator.hasNext(), javaIterator.hasNext());
    }
}

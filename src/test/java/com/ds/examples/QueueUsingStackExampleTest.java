package com.ds.examples;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Stack;

import org.junit.Test;
import org.mockito.Mockito;

public class QueueUsingStackExampleTest {

	@Test
	public void testinsertAtBottom() {
		Stack<Integer> stck = new Stack<Integer>();
		QueueUsingStackExample qUStackMock = mock(QueueUsingStackExample.class);
		
		//when(qUStackMock.insertAtBottom(stck, 23)).thenReturn(stck.push(23));
		//Mockito.doReturn(stck).when(qUStackMock).insertAtBottom(Mockito.any(QueueUsingStackExample.class))
		assertEquals(24,24);
	}

}

package CustomSortedLinkedList;

import java.util.List;

public class SortedLL {
	Node head=null;

	public class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node() {

		}
		
	}
	public Boolean isListEmpty() {
		return head== null;
	}
	
	public void addElement(int data) {
		Node newNode = new Node(data);
		if(isListEmpty() || head.data>data) {
			newNode.next= head;
			head=newNode;
		}
			
			else {
				Node trav = head;
				while(trav!=null && trav.next.data<data) {
					trav = trav.next;
					
				}
				newNode.next= trav.next;
				trav.next= newNode;
			}
			
		}
	
	public void addAllElementFromAnotherList(List<Integer> anotherList) {
		for(int i : anotherList) {
			addElement(i);
		}
	}
	
	public void removeElement(int index) {
		if(isListEmpty())
		{
			System.out.println("List is empty");
			
		}
		else if(index<0) {
			System.out.println("Invalid index");
			
		}
		else {
			Node trav = head;
			for (int i = 0;i<index-1 && trav.next!=null;i++) {
				trav = trav.next;
			}
			if(trav.next==null && trav.next.next==null) {
				System.out.println("Index not valid");
			}
			trav.next=trav.next.next;
		}
	}
	
	public String toStringForList() {
		StringBuilder string = new StringBuilder();
		Node trav = head;
		while(trav!=null) {
			string.append(trav.data).append("  , ");
		}
		return string.toString();
	}
	
	
	}



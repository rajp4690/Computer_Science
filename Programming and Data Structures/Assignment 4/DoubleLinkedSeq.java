public class DoubleLinkedSeq implements Cloneable{

  private DoubleNode head, tail, current;
  private int manyNodes;

  public DoubleLinkedSeq(){
    head = tail = current = null;
    manyNodes = 0;
  }

  public void addAfter(double element){
    if(manyNodes == 0){
      head = new DoubleNode(element, null);
      tail = current = head;
    }
    else if(current == null){
      tail.addNodeAfter(element);
      tail = tail.getLink();
      current = tail;
    }
    else{
      current.addNodeAfter(element);
      current = current.getLink();
    }
    manyNodes++;
  }

  public void addBefore(double element){
    if(manyNodes == 0){
      head = new DoubleNode(element, null);
      tail = current = head;
    }
    else if(current == null || current == head){
      head = new DoubleNode(element, head);
      current = head;
    }
    else{
      DoubleNode cursor;
      for(cursor = head; cursor.getLink() != current; cursor = cursor.getLink()){
      }
      cursor.addNodeAfter(element);
      current = cursor.getLink();
    }
    manyNodes++;
  }

  public void addAll(DoubleLinkedSeq addend){
    DoubleNode[] addendCopy = DoubleNode.listCopyWithTail(addend.head);
    tail.setLink(addendCopy[0]);
    tail = addendCopy[1];
    manyNodes += addend.manyNodes;
  }

  public void advance(){
    if(isCurrent())
      current = current.getLink();
  }

  public DoubleLinkedSeq clone( ){
    DoubleLinkedSeq answer = new DoubleLinkedSeq();
    DoubleNode[] copy = DoubleNode.listCopyWithTail(head);
    answer.head = copy[0];
    answer.tail = copy[1];
    answer.manyNodes = manyNodes;
    if(!isCurrent())
      answer.current = null;
    else{
      int place = 1;
      for(DoubleNode cursor = head; cursor != current; cursor = cursor.getLink()){
        place++;
      }
      answer.current = DoubleNode.listPosition(answer.head, place);
    }
    return answer;
  }

  public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2){
    DoubleLinkedSeq answer = s1.clone();
    answer.addAll(s2);
    answer.current = null;
    return answer;
  }

  public double getCurrent(){
    if(isCurrent())
      return current.getData();
    else
      throw new IllegalStateException("there is no current element");
  }

  public boolean isCurrent(){
    return (current != null);
  }

  public void removeCurrent(){
    if(current == head){
      head = current = tail = null;
    }
    else{
      DoubleNode cursor;
      for(cursor = head; cursor.getLink() != current; cursor = cursor.getLink()){
      }
      current = current.getLink();
      cursor.removeNodeAfter();
    }
    manyNodes--;
  }

  public int size(){
    return manyNodes;
  }

  public void start(){
    current = head;
  }

  public void print(){
    System.out.println("   length = " + size());
    if(current == null)
      System.out.println("   there is no current element");
    else
      System.out.println("   current element = " + getCurrent());
    System.out.print("   elements: ");
    for(DoubleNode cursor = head; cursor != null; cursor = cursor.getLink())
      System.out.printf("%5.1f", cursor.getData());
    System.out.println("\n");
  }

}

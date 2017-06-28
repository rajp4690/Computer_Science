public class DoubleArraySeq implements Cloneable{

  private double[] data;
  private int manyItems;
  private int currentIndex;

  public DoubleArraySeq(){
    data = new double[10];
    manyItems = currentIndex = 0;
  }

  public DoubleArraySeq(int initialCapacity){
    data = new double[initialCapacity];
    manyItems = currentIndex = 0;
  }

  public void addAfter(double element){
    if(data.length == manyItems)
      ensureCapacity(2 * data.length);
    if(currentIndex == manyItems)
      currentIndex = manyItems - 1;
    else if(currentIndex != 0){
      double[] answer = new double[data.length];
      System.arraycopy(data, currentIndex + 1, data, currentIndex + 2, manyItems - currentIndex - 1);
    }
    data[currentIndex + 1] = element;
    currentIndex++;
    manyItems++;
  }

  public void addBefore(double element){
    if(data.length == manyItems)
      ensureCapacity(2 * data.length);
    else{
      if(currentIndex == manyItems)
        currentIndex = 0;
      else
        System.arraycopy(data, currentIndex, data, currentIndex + 1, manyItems - currentIndex);

      data[currentIndex] = element;
      manyItems++;
    }
  }

  public void addAll(DoubleArraySeq addend){
    if(addend != null){
      if(data.length < manyItems + addend.manyItems)
        ensureCapacity(manyItems + addend.manyItems);

      System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
      manyItems += addend.manyItems;
    }
  }

  public void advance(){
    if(currentIndex == manyItems - 1)
      currentIndex = manyItems;
    else
      currentIndex++;
  }

  public DoubleArraySeq clone( ){
    DoubleArraySeq answer;

    try{
      answer = (DoubleArraySeq) super.clone( );
    }
    catch (CloneNotSupportedException e){
      throw new RuntimeException
        ("This class does not implement Cloneable");
    }

    answer.data = data.clone( );
    return answer;
  }

  public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2){
    DoubleArraySeq answer = new DoubleArraySeq(s1.manyItems + s2.manyItems);
    answer.addAll(s1);
    answer.addAll(s2);
    answer.currentIndex = answer.manyItems;
    return answer;
  }

  public void ensureCapacity(int minimumCapacity){
    if(data.length <= minimumCapacity){
      double[] answer = new double[minimumCapacity];
      System.arraycopy(data, 0, answer, 0, manyItems);
      data = answer;
    }
  }

  public int getCapacity(){
    return data.length;
  }

  public double getCurrent(){
    if(isCurrent())
      return data[currentIndex];
    else
      throw new RuntimeException("IllegalStateException");
  }

  public boolean isCurrent(){
    return (currentIndex != manyItems);
  }

  public void removeCurrent(){
    if(currentIndex == manyItems - 1)
      currentIndex = manyItems;
    else
      System.arraycopy(data, currentIndex + 1, data, currentIndex, manyItems - currentIndex);

    manyItems--;
  }

  public int size(){
    return manyItems;
  }

  public void start(){
      currentIndex = 0;
  }

  public void trimToSize( ){
    double[ ] trimmedArray;
    if (data.length != manyItems){
      trimmedArray = new double[manyItems];
      System.arraycopy(data, 0, trimmedArray, 0, manyItems);
      data = trimmedArray;
    }
  }

  public void print(){
    System.out.println("   capacity = " + getCapacity());
    System.out.println("   length = " + size());
    if(currentIndex == manyItems)
      System.out.println("   there is no current element");
    else
      System.out.println("   current element = " + getCurrent());

    System.out.print("   elements: ");
    for(int i = 0; i < manyItems; i++)
      System.out.printf("%5.1f", data[i]);

    System.out.println("\n");
  }
}

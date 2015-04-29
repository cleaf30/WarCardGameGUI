/**
   Exception thrown when a List is accessed with an
   illegal index
 */
public class ListIndexOutOfBoundsException 
            extends IndexOutOfBoundsException {
  public ListIndexOutOfBoundsException(String s) {
    super(s);
  }  
}  
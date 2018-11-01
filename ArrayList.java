public class ArrayList implements List {
    private Object[] arr;
    private int count;

    public ArrayList(){
        arr = new Object[10]; 
        count = 0; 
    }

    public void grow(){
        Object[] newArr = new Object[2*arr.length]; 
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i]; 
        }
        arr = newArr; 
    }

    public void add(Object obj){
        if(count==arr.length){ 
            grow();
        }
        arr[count] = obj; 
        count++; 
    }

    public void add(int pos, Object obj){
        if(count==arr.length){ 
            grow();
        }
        if(pos==count) 
            arr[pos] = obj;
        else {
            Object[] newArr = new Object[arr.length]; 
            for (int i = 0; i < pos; i++) { 
                newArr[i] = arr[i];
            }
            newArr[pos] = obj;
            for (int j = pos; j < count; j++) {
                newArr[j + 1] = arr[j]; 
            }
        }
        count++; 
    }
    
    public Object remove(int pos){
        Object[] newArr = new Object[arr.length]; 
        Object return_object = arr[pos]; 
        for(int i=0;i<count-1;i++){
            if(i<pos)
                newArr[i] = arr[i]; 
            else
                newArr[i] = arr[i+1];
        }
        count--; 
        arr = newArr; 
        return return_object; 
    }

    public Object get(int pos){
        return arr[pos]; 
    }

    public int size(){
        return count; 
    }
}
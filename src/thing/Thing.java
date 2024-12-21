package thing;

public abstract class Thing {
    private boolean dirty;

    public Thing(){
        this.dirty = false;
    }

    public Thing(boolean dirty){
        this.dirty = dirty;
    }

    public void cleanIt(){
        this.dirty = false;
    }

    public void dirtyIt(){
        this.dirty = true;
    }

    public boolean isDirty() {
        return dirty;
    }
}

class Task{
    int id;
    String description, status;
    Task(int id, String description, String status){
        this.id = id;
        this.description = description;
        this.status = status;
    }    
    @Override
    public String toString() {
        return this.id + " " + this.description + " " + this.status;
    }
}
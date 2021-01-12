package ru.sapteh;

public class Students {
    public static final String TABLE_NAME = "baza";
    public static final String ID_COLUMN = "id";
    public static final String FIRSTNAME_COLUMN = "firstName";
    public static final String MIDDLENAME_COLUMN = "middleName";
    public static final String LASTNAME_COLUMN = "lastName";
    public static final String BIRTDAY_COLUMN = "birtDay";
    public static final String SPECIALNOST_COLUMN = "specialnost";
    public static final String COURSE_COLUMN = "course";
    public static final String GRUPS_COLUMN = "grups";

    private int id;
    private String firstName;
    private String middlName;
    private String lastName;
    private String birtDay;
    private String specialnost;
    private String course;
    private String grups;

    public Students (int id, String firstName, String middlName, String lastName, String birtDay, String specialnost, String course, String grups){
            this.id = id;
            this.firstName = firstName;
            this.middlName = middlName;
            this.lastName = lastName;
            this.birtDay = birtDay;
            this.specialnost = specialnost;
            this.course = course;
            this.grups = grups;

        }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getFirstName(){
            return firstName;
        }
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        public String getMiddlName(){
            return middlName;
        }
        public void setMiddlName( String middlName){
            this.middlName = middlName;
        }
        public String getLastName(){
            return lastName;
        }
        public void setLastName(String lastName){
            this.lastName = lastName;
        }
        public String getBirtDay(){
            return birtDay;
        }
        public void setBirtDay(String birtDay){
            this.birtDay = birtDay;
        }

        public String getSpecialnost(){
            return specialnost;
        }
        public void setSpecialnost(String specialnost){
            this.specialnost = specialnost;
        }
        public String getCourse(){
            return course;
        }
        public void setCourse(String course){
            this.course = course;
        }
        public String getGrups(){
        return grups;
        }
        public void setGrups(String grups){
        this.grups = grups;
        }


        @Override
        public String toString(){
            return String.format("%d,%s,%s,%s,%s,%s,%s,%s", getId(),getFirstName(), getMiddlName(), getLastName(), getBirtDay(),getSpecialnost(), getGrups());
        }



}



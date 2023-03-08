package com.study_group;

import com.auxiliary.TextColor;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

/**
 * The class of objects that are contained in the collection
 */
public class StudyGroup {
    private final UUID id;
    private final String name;
    private final Coordinates coordinates;
    private final LocalDateTime creationDate;
    private final Integer studentsCount;
    private final int expelledStudents;
    private final long shouldBeExpelled;
    private final Semester semesterEnum;
    private final Person groupAdmin;

    public StudyGroup(String name, Coordinates coordinates, Integer studentsCount, int expelledStudents, long shouldBeExpelled, Semester semesterEnum, Person groupAdmin, LocalDateTime creationDate, UUID id) {
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.groupAdmin = groupAdmin;
        this.expelledStudents = expelledStudents;
        this.shouldBeExpelled = shouldBeExpelled;
        this.semesterEnum = semesterEnum;
        this.creationDate = creationDate;
        this.id = id;
    }


    /**
     * Call a method from AddCommand class according to which field user wants to update
     * @param num - number of the field user wants to update
     */
    public void updateField(int num) throws IOException {
        //TODO: add this method
    }



    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    @Override
    public String toString() {
        String id_str = TextColor.ANSI_PURPLE + "\n\tid" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + id + TextColor.ANSI_RESET;
        String name_str = TextColor.ANSI_PURPLE + "\n\t" + "name" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + name + TextColor.ANSI_RESET;
        String coords_str = TextColor.ANSI_PURPLE + "\n\t" + "coordinates" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + coordinates.toString() + TextColor.ANSI_RESET;
        String studs_cnt_str = TextColor.ANSI_PURPLE + "\n\t" + "number of students" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + studentsCount + TextColor.ANSI_RESET;
        String studs_exp_str = TextColor.ANSI_PURPLE + "\n\t" + "expelled students" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + expelledStudents + TextColor.ANSI_RESET;
        String studs_should_exp_str = TextColor.ANSI_PURPLE + "\n\t" + "should be expelled" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + shouldBeExpelled + TextColor.ANSI_RESET;
        String sem_str = TextColor.ANSI_PURPLE + "\n\t" + "semester" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_CYAN + semesterEnum + TextColor.ANSI_RESET;
        String admin_str = TextColor.ANSI_PURPLE + "\n\t" + "admin" + TextColor.ANSI_WHITE + ": " + TextColor.ANSI_RESET + "{" + groupAdmin.toString() + "\n\t}";

        return "\n{" + id_str + name_str + coords_str + studs_cnt_str + studs_exp_str + studs_should_exp_str + sem_str + admin_str + "\n}" + "\n\n--------------------------------";
    }

    /**
     * Searches through the collection and finds the group by its name
     * @param groups - collection
     * @param name - name of the group user wants to find
     * @return StudyGroup
     */
    public static StudyGroup findByName(LinkedList<StudyGroup> groups, String name) {
        for (StudyGroup group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }


    public Person getAdmin(){
        return groupAdmin;
    }


    /**
     * Making a string of all the fields
     * @return String
     */
    public String getParams(){
        return name + "," + coordinates.get_params() + "," + creationDate + "," +
                studentsCount + "," + expelledStudents + "," + shouldBeExpelled + "," + Semester.find(semesterEnum) + ',' + groupAdmin.getParams() + ',' + id + "\n";
    }

}






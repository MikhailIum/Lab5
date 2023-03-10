package com.study_group;

/** Enum class of semesters on which a group can be */
public enum Semester {
  FIRST("1"),
  SECOND("2"),
  FOURTH("4"),
  SIXTH("6"),
  SEVENTH("7");

  final String num;

  Semester(String num) {
    this.num = num;
  }

  /**
   * Finds name of the semester by number
   *
   * @param s - number of the semester
   * @return Enum Semester
   */
  public static Semester find(String s) {
    switch (s) {
      case ("1"):
        return FIRST;
      case ("2"):
        return SECOND;
      case ("4"):
        return FOURTH;
      case ("6"):
        return SIXTH;
      case ("7"):
        return SEVENTH;
      default:
        return null;
    }
  }

  /**
   * Finds number of the semester by its name
   *
   * @param s - name of the semester
   * @return number
   */
  public static String find(Semester s) {
    return s.num;
  }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        CoursePlan coursePlan = CoursePlan.create(numCourses, prerequisites);
        return coursePlan.canFinishAllCourses();
    }

    private static final class CoursePlan {
        private final List<List<Integer>> coursesUnlockedBy;
        private final int[] prerequisiteCount;
        private final Queue<Integer> readyCourses;
        private int finishedCourseCount;

        private CoursePlan(int numCourses) {
            this.coursesUnlockedBy = new ArrayList<>();
            for (int course = 0; course < numCourses; course++) {
                coursesUnlockedBy.add(new ArrayList<>());
            }
            this.prerequisiteCount = new int[numCourses];
            this.readyCourses = new ArrayDeque<>();
        }

        private static CoursePlan create(int numCourses, int[][] prerequisites) {
            CoursePlan coursePlan = new CoursePlan(numCourses);
            for (int[] relation : prerequisites) {
                coursePlan.addPrerequisite(relation[1], relation[0]);
            }
            coursePlan.enqueueReadyCourses();
            return coursePlan;
        }

        private void addPrerequisite(int prerequisiteCourse, int targetCourse) {
            coursesUnlockedBy.get(prerequisiteCourse).add(targetCourse);
            prerequisiteCount[targetCourse]++;
        }

        private void enqueueReadyCourses() {
            for (int course = 0; course < prerequisiteCount.length; course++) {
                if (prerequisiteCount[course] == 0) {
                    readyCourses.offer(course);
                }
            }
        }

        private boolean canFinishAllCourses() {
            while (!readyCourses.isEmpty()) {
                takeNextReadyCourse();
            }
            return finishedCourseCount == coursesUnlockedBy.size();
        }

        private void takeNextReadyCourse() {
            int currentCourse = readyCourses.poll();
            finishedCourseCount++;

            for (int unlockedCourse : coursesUnlockedBy.get(currentCourse)) {
                completePrerequisiteFor(unlockedCourse);
            }
        }

        private void completePrerequisiteFor(int course) {
            prerequisiteCount[course]--;
            if (prerequisiteCount[course] == 0) {
                readyCourses.offer(course);
            }
        }
    }
}

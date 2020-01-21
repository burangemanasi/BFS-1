class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        //populating the indegrees array for every occurence
        for(int i=0; i<prerequisites.length; i++)
            indegrees[prerequisites[i][1]]++;
        
        //initially, adding course with indegree value 0 to queue
        //first level
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i]==0)
                queue.add(i);
        }
        
        //exploring courses from queue
        while(!queue.isEmpty()){
            int curr_course = queue.poll();
            
            for(int i=0; i<prerequisites.length; i++){
                //checking if the course is a prerequisite for any other course
                if(prerequisites[i][0]==curr_course){
                    indegrees[prerequisites[i][1]]--;
                
                    //if the indegree value becomes zero then add to the queue
                    if(indegrees[prerequisites[i][1]] == 0)
                        queue.add(prerequisites[i][1]);
                }
            }
        }
        //check the courses which have indegree value greater than zero that means cannot complete
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] != 0)
                return false;
        }
        return true;
    }
}
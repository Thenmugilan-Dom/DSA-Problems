import java.util.*;

class TaskManager {
    private PriorityQueue<int[]> maxHeap;
    private Map<Integer, int[]> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]); // higher priority first
            return Integer.compare(b[1], a[1]); // tie -> higher taskId first
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            maxHeap.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        maxHeap.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        int userId = info[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        maxHeap.offer(new int[]{newPriority, taskId});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); 
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int priority = top[0], taskId = top[1];

            int[] info = taskMap.get(taskId);
            if (info == null) {
                continue;
            }
            if (info[1] == priority) {
                taskMap.remove(taskId);
                return info[0]; 
            }
        }
        return -1;
    }
}

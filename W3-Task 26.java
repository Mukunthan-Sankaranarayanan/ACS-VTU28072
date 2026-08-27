class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            while(!stack.isEmpty()&&stack.peek()>0&& asteroid<0){
                int top=stack.peek();
                if(top<-asteroid){
                    stack.pop();
                }
                else if(top==-asteroid){
                    stack.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(asteroid);
            }
        }
        int[] result=new int[stack.size()];
        for(int i= result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}

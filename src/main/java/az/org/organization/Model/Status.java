package az.org.organization.Model;

public enum Status {

        ACTIVE("Task is active,but not running"),
        TODO("Task is running"),
        DONE("Task is done");
        private final String message;

        Status(String message){
            this.message = message;

        }
        @Override
        public String toString(){
            return message;
        }

    }


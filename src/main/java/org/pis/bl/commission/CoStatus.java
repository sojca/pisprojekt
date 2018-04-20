package org.pis.bl.commission;

public enum CoStatus {
    NEW("New"),
    PARTLY_FINISHED("Partly finished"),
    FINISHED("Finished");

    private String label;

    private CoStatus(String status) {
        this.label = status;
    }

    public String getLabel() {
        return label;
    }
    public boolean equals(String status){
        return status.toLowerCase().equals(status.toLowerCase());
    }
}

package com.example.ivanchow.portablepc;


public class Group {
    String groupId;
    String groupName;

    public Group() {

    }

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }
}
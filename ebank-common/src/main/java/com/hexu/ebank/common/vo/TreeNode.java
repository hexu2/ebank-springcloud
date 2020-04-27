package com.hexu.ebank.common.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class TreeNode {

    protected int id;

    protected int parentId;

    List<TreeNode> children = new ArrayList<>();

    public void add(TreeNode node){

        children.add(node);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
    }

}

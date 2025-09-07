package com.demomod;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;

public class VeinMine {


    public static List<BlockPos> findBlocks(BlockPos startingBlockPos, World world){
        BlockState startState = world.getBlockState(startingBlockPos);
        if(!world.isClient() && startState.getBlock() != Blocks.AIR){
            return findBlockPath(world, startingBlockPos, startState);
        }
        return null;
    }

    public static List<BlockPos> findBlockPath(World world, BlockPos startingBlockPos, BlockState startState){ //DFS METHOD
        Set<BlockPos> visited = new HashSet<>();
        LinkedList<BlockPos> foundBlocks = new LinkedList<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.add(startingBlockPos);
        visited.add(startingBlockPos);

        while(!queue.isEmpty()){
            BlockPos current = queue.poll();
            visited.add(current);

            BlockState currentState = world.getBlockState(current);
            System.out.println("Checking " + current + " state=" + currentState.getBlock());



            if(currentState.getBlock().equals(startState.getBlock())){
                foundBlocks.add(current);
                findAllNeighbors(current, currentState, world, visited, foundBlocks, queue);
            }

        }

        return foundBlocks;
    }

    public static void findAllNeighbors(BlockPos centerBlockPos,
                                 BlockState centerBlockState,
                                 World world,
                                 Set<BlockPos> visited,
                                 LinkedList<BlockPos> foundBlocks,
                                 Queue<BlockPos> queue){ //DFS HELPER
        ArrayList<BlockPos> neighbors = new ArrayList<>();

        for(int dx = -1; dx <= 1; dx++){
            for(int dy = -1; dy <= 1; dy++){
                for(int dz = -1; dz <= 1; dz++){
                    if(dx == 0 && dy == 0 && dz == 0){
                        continue;
                    }

                    BlockPos currentBlockPos = centerBlockPos.add(dx, dy, dz);
                    BlockState currentBlockState = world.getBlockState(currentBlockPos);
                    if(currentBlockState.getBlock().equals(centerBlockState.getBlock())) {
                        if(!visited.contains(currentBlockPos)) {
                            visited.add(currentBlockPos);
                            foundBlocks.add(currentBlockPos);
                            queue.add(currentBlockPos);

                        }
                    }

                }
            }
        }
    }


}

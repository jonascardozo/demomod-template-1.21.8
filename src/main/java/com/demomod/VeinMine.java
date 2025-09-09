package com.demomod;



import com.demomod.config.ConfigData;
import com.demomod.config.ConfigReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.*;

public class VeinMine {

    public static ConfigReader configReader = new ConfigReader();

    public static void searchForBlocks(World world, BlockPos startingBlockPos, BlockState startState, ArrayList<BlockPos> founfBlocks)
    {

    }

    public static List<BlockPos> findBlockPath(World world,
                                               BlockPos startingBlockPos,
                                               BlockState startState,
                                               ArrayList<BlockPos> foundBlocks) { //DFS METHOD

        if (foundBlocks.size() >= ConfigData.getInstance().dfs_limit)
            return foundBlocks;
        int x = startingBlockPos.getX();
        int y = startingBlockPos.getY();
        int z = startingBlockPos.getZ();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos current = new BlockPos(x + dx, y + dy, z + dz);
                    BlockState state = world.getBlockState(current);
                    if (!state.equals(startState))
                        continue;

                    boolean inList = false;
                    for (BlockPos block : foundBlocks) {
                        if (block.equals(current)) {

                            inList = true;
                            break;


                        }

                    }
                    if (inList)
                        continue;
                    foundBlocks.add(current);
                    findBlockPath(world, current, startState, foundBlocks);

                }

            }
        }

        public static List<BlockPos> findBlockCube(){

        }


        return foundBlocks;
    }


}

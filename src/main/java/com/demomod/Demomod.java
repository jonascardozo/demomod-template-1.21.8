package com.demomod;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.authlib.yggdrasil.request.TelemetryEventsRequest.Event;

public class Demomod implements ModInitializer {
	public static final String MOD_ID = "demomod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

 
	public static final Item SUSPICIOUS_SUBSTANCE = ModItems.register("suspicious_substance", Item::new, new Item.Settings().maxCount(64), true);
	public static final Item POOP = ModItems.register("poop", Item::new, new Item.Settings().maxCount(64), false);
	
	
	public void onInitialize() {
		
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		
		ModItems.initialize();


        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if(!world.isClient()) {
                System.out.println("hello");
                System.out.println("hello");
                veinMine(world, pos, state, (ServerPlayerEntity) player);

            }
        });
    }

    private void veinMine(World world, BlockPos pos, BlockState state, ServerPlayerEntity player)
    {
        System.out.println("hello");
        var blocks = VeinMine.findBlocks(pos, world);
        if(blocks != null) {
            for (BlockPos b : blocks) {
                if(!b.equals(pos)){
                    world.breakBlock(b, true, player);
                    System.out.println("block broken" + b.toString());
                }
            }
        }
    }




}
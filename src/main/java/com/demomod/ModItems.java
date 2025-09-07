package com.demomod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import java.util.function.Function;
import net.minecraft.text.Text;




public class ModItems {

	public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Demomod.MOD_ID, "item_group"));

    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Demomod.SUSPICIOUS_SUBSTANCE)) // Set your item as the icon
            .displayName(Text.translatable("itemGroup.tutorial.custom_item_group")) // Reference your lang file
            .entries((context, entries) -> {
                entries.add(Demomod.SUSPICIOUS_SUBSTANCE); // Add your custom item
				entries.add(Demomod.POOP);
                // Add more items or blocks from your mod here
            })
            .build();
	

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings, boolean registerItemGroup) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Demomod.MOD_ID, name));

		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));

		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);

		if(registerItemGroup)
			Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
		

		return item;

        
	}
	

    public static void initialize() {
        
    }

}
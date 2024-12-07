package beaver.mom.overworldanchor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.EndCrystalItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class TemmiesOverworldAnchor implements ModInitializer {
    public static final Item ECHO_NUGGET = Registry.register(Registries.ITEM, Identifier.of("overworldanchor", "echo_nugget"), new EchoNugget());

    public static final OverworldAnchorBlock OVERWORLD_ANCHOR_BLOCK = Registry.register(Registries.BLOCK, Identifier.of("overworldanchor", "overworld_anchor"), new OverworldAnchorBlock());
    public static final BlockEntityType<OverworldAnchorBlockEntity> OVERWORLD_ANCHOR_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("overworldanchor", "overworld_anchor_block_entity"), FabricBlockEntityTypeBuilder.create(OverworldAnchorBlockEntity::new, OVERWORLD_ANCHOR_BLOCK).build());
    public static final OverworldAnchorBlockItem OVERWORLD_ANCHOR_BLOCK_ITEM = Registry.register(Registries.ITEM, Identifier.of("overworldanchor", "overworld_anchor"), new OverworldAnchorBlockItem());
    public static final SpecialRecipeSerializer<OverworldAnchorBlockCraftingRecipe> OVERWORLD_ANCHOR_BLOCK_CRAFTING_RECIPE = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of("overworldanchor", "overworld_anchor_recipe"), new SpecialRecipeSerializer<>(OverworldAnchorBlockCraftingRecipe::new));

    @Override
    public void onInitialize() {
        OverworldAnchorBlock.registerDispenserBehaviour();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(ECHO_NUGGET);
        });
    }
}

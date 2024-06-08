package info.tritusk.modpack.waterspring;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FabricEntryPoint implements ModInitializer {
    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild("water_spring", "water_spring"),
                new WaterSpringBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));
    }
}

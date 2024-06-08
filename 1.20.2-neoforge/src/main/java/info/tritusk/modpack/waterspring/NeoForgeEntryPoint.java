package info.tritusk.modpack.waterspring;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod("water_spring")
public final class NeoForgeEntryPoint {

    public NeoForgeEntryPoint(IEventBus modBus) {
        modBus.addListener(RegisterEvent.class, NeoForgeEntryPoint::reg);
    }

    private static void reg(RegisterEvent event) {
        if (!Registries.BLOCK.equals(event.getRegistryKey())) {
            return;
        }

        Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild("water_spring", "water_spring"),
                new WaterSpringBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(-1F, 3600000F)
                        .noLootTable()
                        .isValidSpawn((state, levelView, pos, eType) -> false)));
    }
}

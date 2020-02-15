package com.baltbolt.cubemobmod;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid=TestMod.MOD_ID, version=TestMod.MOD_VERSION)
public class TestMod {
	public static final String MOD_ID = "cubemobmod";
	public static final String MOD_VERSION = "1.0";

	//public static Item ruby;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		ruby=new Item()
				.setCreativeTab(CreativeTabs.MATERIALS)
				.setMaxStackSize(64)
				.setUnlocalizedName("ruby")
				.setRegistryName("ruby");
		ForgeRegistries.ITEMS.register(ruby);
		*/
		
		if(event.getSide().isClient())
		{
			//ModelLoader.setCustomModelResourceLocation(ruby, 0, new ModelResourceLocation("testmod:ruby"));
			
			RenderingRegistry.registerEntityRenderingHandler(EntityCube.class, new IRenderFactory<EntityCube>()
					{
						@Override
						public Render<? super EntityCube> createRenderFor(RenderManager manager)
						{
							return new RenderCube(manager,new ModelCube(),0.4F);
						}
					});
		}
		
		EntityRegistry.registerModEntity(new ResourceLocation("cube"), EntityCube.class, "cube", 0, this, 50, 1, true, 16666900, 000000);
		
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("plains")),
				   			   Biome.REGISTRY.getObject(new ResourceLocation("forest")),
				   			   Biome.REGISTRY.getObject(new ResourceLocation("taiga")),
				   			   Biome.REGISTRY.getObject(new ResourceLocation("swampland")),
				   			   Biome.REGISTRY.getObject(new ResourceLocation("savanna")),
				   			   Biome.REGISTRY.getObject(new ResourceLocation("birch_forest")),
							   Biome.REGISTRY.getObject(new ResourceLocation("desert"))};
		
		EntityRegistry.addSpawn(EntityCube.class, 20, 3, 30, EnumCreatureType.AMBIENT , spawnBiomes);
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{

	}
}

package biomesoplenty.common.biome.overworld;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.Height;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.common.biome.BOPOverworldBiome;
import biomesoplenty.common.configuration.BOPConfigurationMisc;

public class BiomeGenCrag extends BOPOverworldBiome
{
	private static final Height biomeHeight = new Height(2.0F, 3.0F);
	
	public BiomeGenCrag(int id)
	{
		super(id);

        this.setHeight(biomeHeight);
        this.setColor(5209457);
        this.setTemperatureRainfall(2.0F, 0.0F);
		
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.topBlock = BOPCBlocks.cragRock;
		this.fillerBlock = BOPCBlocks.cragRock;
		this.theBiomeDecorator.treesPerChunk = -999;

		this.waterColorMultiplier = 944693;
	}
	
	@Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
        int var5 = 12 + random.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(28) + 4;
            int z = chunkZ + random.nextInt(16);
            
            //TODO:             getBlock()
            Block block = world.getBlock(x, y, z);

            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
            {
                //TODO: setBlock()
                world.setBlock(x, y, z, Blocks.emerald_ore, 0, 2);
            }
        }
    }
	
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 if (BOPConfigurationMisc.skyColors) return 4944498;
		 else return super.getSkyColorByTemp(par1);
	 }
	
	/**
	 * Fog Color
	 */
	/*
	@Override
	public int getFogColour()
	{
		return 10514245;
	}
	*/
	 
	/*
    @Override
    public float getFogCloseness()
    {
        // TODO Auto-generated method stub
        return 1.0F;
    }
    */
}

package slimeknights.tconstruct.library.materials;

import com.google.common.collect.ImmutableList;

import java.util.List;

import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.client.CustomFontColor;

public class HandleMaterialStats extends AbstractMaterialStats {

  public final static String TYPE = "handle";

  public final static String LOC_Multiplier = "stat.handle.modifier.name";
  public final static String LOC_Durability = "stat.handle.durability.name";

  public final static String LOC_MultiplierDesc = "stat.handle.modifier.desc";
  public final static String LOC_DurabilityDesc = "stat.handle.durability.desc";

  public final static String COLOR_Durability = HeadMaterialStats.COLOR_Durability;
  public final static String COLOR_Modifier = CustomFontColor.encodeColor(205, 205, 100);

  public final float modifier; // how good the material is for handles. 0.0 - 1.0
  public final int durability; // usually between -500 and 500

  public HandleMaterialStats(float modifier, int durability) {
    super(TYPE);
    this.durability = durability;
    this.modifier = modifier;
  }

  @Override
  public List<String> getLocalizedInfo() {
    return ImmutableList.of(formatModifier(modifier),
                            formatDurability(durability));
  }

  @Override
  public List<String> getLocalizedDesc() {
    return ImmutableList.of(Util.translate(LOC_MultiplierDesc),
                            Util.translate(LOC_DurabilityDesc));
  }


  public static String formatModifier(float quality) {
    return formatNumber(LOC_Multiplier, COLOR_Modifier, quality);
  }

  public static String formatDurability(int durability) {
    return formatNumber(LOC_Durability, COLOR_Durability, durability);
  }
}

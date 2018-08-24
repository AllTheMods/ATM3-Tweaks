package atm.bloodworkxgaming.atmtweaks.items;

import it.unimi.dsi.fastutil.ints.Int2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

public enum EnumItemMaterial {
    INVALID_ITEM(32766, "invalid_item", 64, false),
    ATM_STAR(0, "atm_star", 1, true),
    GROWTH_ESSENCE(1, "growth_essence", 64, false),
    INDUSTRIUM_ALLOY(2, "industrium_alloy", 64, false),
    FORGED_INDUSTRIUM(3, "forged_industrium", 64, true),
    ANIMA_MUNDI(4, "anima_mundi", 64, false),
    ORB_OF_TRANSCENDENCE(5, "orb_of_transcendence", 1, false),
    SCHWARZSCHILD_SPHERE(6, "schwarzschild_sphere", 1, false),
    UNIFIED_FIELD_CORE(7, "unified_field_core", 64, false),
    PARADOXICALLY_DENSE_COMPONENT(8, "paradoxically_dense_component", 64, false),
    DRAGON_ESSENCE(9, "dragon_essence", 64, false),
    WITHER_ESSENCE(10, "wither_essence", 64, false);

    private static Int2ObjectMap<EnumItemMaterial> metaMap = new Int2ObjectAVLTreeMap<>();

    static {
        for (EnumItemMaterial enumItemMaterial : values()) {
            metaMap.put(enumItemMaterial.meta, enumItemMaterial);
        }
    }

    private int meta;
    private String name;
    private int stackSize;
    private boolean hasEffectGlow;

    EnumItemMaterial(int meta, String name, int stackSize, boolean hasEffectGlow) {
        this.meta = meta;
        this.name = name;
        this.stackSize = stackSize;
        this.hasEffectGlow = hasEffectGlow;
    }

    public static EnumItemMaterial getFromMeta(int meta) {
        EnumItemMaterial material = metaMap.get(meta);
        return material != null ? material : INVALID_ITEM;
    }

    public int getMeta() {
        return this.meta;
    }

    public String getName() {
        return this.name;
    }

    public int getStackSize() {
        return this.stackSize;
    }

    public boolean hasEffectGlow() {
        return this.hasEffectGlow;
    }
}

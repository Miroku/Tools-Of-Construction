// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            StatCrafting, GuiSlotStatsBlock, StatList, GuiStats, 
//            StatFileWriter

class SorterStatsBlock
    implements Comparator
{

    final GuiStats statsGUI; /* synthetic field */
    final GuiSlotStatsBlock slotStatsBlockGUI; /* synthetic field */

    SorterStatsBlock(GuiSlotStatsBlock guislotstatsblock, GuiStats guistats)
    {
        slotStatsBlockGUI = guislotstatsblock;
        statsGUI = guistats;
//        super();
    }

    public int func_27297_a(StatCrafting statcrafting, StatCrafting statcrafting1)
    {
        int i = statcrafting.func_25072_b();
        int j = statcrafting1.func_25072_b();
        StatBase statbase = null;
        StatBase statbase1 = null;
        if(slotStatsBlockGUI.field_27271_e == 2)
        {
            statbase = StatList.mineBlockStatArray[i];
            statbase1 = StatList.mineBlockStatArray[j];
        } else
        if(slotStatsBlockGUI.field_27271_e == 0)
        {
            statbase = StatList.objectCraftStats[i];
            statbase1 = StatList.objectCraftStats[j];
        } else
        if(slotStatsBlockGUI.field_27271_e == 1)
        {
            statbase = StatList.objectUseStats[i];
            statbase1 = StatList.objectUseStats[j];
        }
        if(statbase != null || statbase1 != null)
        {
            if(statbase == null)
            {
                return 1;
            }
            if(statbase1 == null)
            {
                return -1;
            }
            int k = GuiStats.getStatsFileWriter(slotStatsBlockGUI.field_27274_a).writeStat(statbase);
            int l = GuiStats.getStatsFileWriter(slotStatsBlockGUI.field_27274_a).writeStat(statbase1);
            if(k != l)
            {
                return (k - l) * slotStatsBlockGUI.field_27270_f;
            }
        }
        return i - j;
    }

    public int compare(Object obj, Object obj1)
    {
        return func_27297_a((StatCrafting)obj, (StatCrafting)obj1);
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Packet51MapChunk, Packet, Packet255KickDisconnect, Packet1Login, 
//            Packet10Flying, Packet52MultiBlockChange, Packet14BlockDig, Packet53BlockChange, 
//            Packet50PreChunk, Packet20NamedEntitySpawn, Packet30Entity, Packet34EntityTeleport, 
//            Packet15Place, Packet16BlockItemSwitch, Packet29DestroyEntity, Packet21PickupSpawn, 
//            Packet22Collect, Packet3Chat, Packet23VehicleSpawn, Packet18Animation, 
//            Packet19EntityAction, Packet2Handshake, Packet24MobSpawn, Packet4UpdateTime, 
//            Packet6SpawnPosition, Packet28EntityVelocity, Packet40EntityMetadata, Packet39AttachEntity, 
//            Packet7UseEntity, Packet38EntityStatus, Packet8UpdateHealth, Packet9Respawn, 
//            Packet60Explosion, Packet100OpenWindow, Packet101CloseWindow, Packet102WindowClick, 
//            Packet103SetSlot, Packet104WindowItems, Packet130UpdateSign, Packet105UpdateProgressbar, 
//            Packet5PlayerInventory, Packet106Transaction, Packet25EntityPainting, Packet54PlayNoteBlock, 
//            Packet200Statistic, Packet17Sleep, Packet27Position, Packet70Bed, 
//            Packet71Weather, Packet131MapData, Packet61DoorChange, Packet254ServerPing, 
//            Packet41EntityEffect, Packet42RemoveEntityEffect, Packet201PlayerInfo, Packet0KeepAlive, 
//            Packet43Experience, Packet107CreativeSetSlot, Packet26EntityExpOrb, Packet108EnchantItem

public abstract class NetHandler
{

    public NetHandler()
    {
    }

    public abstract boolean isServerHandler();

    public void handleMapChunk(Packet51MapChunk packet51mapchunk)
    {
    }

    public void registerPacket(Packet packet)
    {
    }

    public void handleErrorMessage(String s, Object aobj[])
    {
    }

    public void handleKickDisconnect(Packet255KickDisconnect packet255kickdisconnect)
    {
        registerPacket(packet255kickdisconnect);
    }

    public void handleLogin(Packet1Login packet1login)
    {
        registerPacket(packet1login);
    }

    public void handleFlying(Packet10Flying packet10flying)
    {
        registerPacket(packet10flying);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange packet52multiblockchange)
    {
        registerPacket(packet52multiblockchange);
    }

    public void handleBlockDig(Packet14BlockDig packet14blockdig)
    {
        registerPacket(packet14blockdig);
    }

    public void handleBlockChange(Packet53BlockChange packet53blockchange)
    {
        registerPacket(packet53blockchange);
    }

    public void handlePreChunk(Packet50PreChunk packet50prechunk)
    {
        registerPacket(packet50prechunk);
    }

    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn packet20namedentityspawn)
    {
        registerPacket(packet20namedentityspawn);
    }

    public void handleEntity(Packet30Entity packet30entity)
    {
        registerPacket(packet30entity);
    }

    public void handleEntityTeleport(Packet34EntityTeleport packet34entityteleport)
    {
        registerPacket(packet34entityteleport);
    }

    public void handlePlace(Packet15Place packet15place)
    {
        registerPacket(packet15place);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16blockitemswitch)
    {
        registerPacket(packet16blockitemswitch);
    }

    public void handleDestroyEntity(Packet29DestroyEntity packet29destroyentity)
    {
        registerPacket(packet29destroyentity);
    }

    public void handlePickupSpawn(Packet21PickupSpawn packet21pickupspawn)
    {
        registerPacket(packet21pickupspawn);
    }

    public void handleCollect(Packet22Collect packet22collect)
    {
        registerPacket(packet22collect);
    }

    public void handleChat(Packet3Chat packet3chat)
    {
        registerPacket(packet3chat);
    }

    public void handleVehicleSpawn(Packet23VehicleSpawn packet23vehiclespawn)
    {
        registerPacket(packet23vehiclespawn);
    }

    public void handleArmAnimation(Packet18Animation packet18animation)
    {
        registerPacket(packet18animation);
    }

    public void handleEntityAction(Packet19EntityAction packet19entityaction)
    {
        registerPacket(packet19entityaction);
    }

    public void handleHandshake(Packet2Handshake packet2handshake)
    {
        registerPacket(packet2handshake);
    }

    public void handleMobSpawn(Packet24MobSpawn packet24mobspawn)
    {
        registerPacket(packet24mobspawn);
    }

    public void handleUpdateTime(Packet4UpdateTime packet4updatetime)
    {
        registerPacket(packet4updatetime);
    }

    public void handleSpawnPosition(Packet6SpawnPosition packet6spawnposition)
    {
        registerPacket(packet6spawnposition);
    }

    public void handleEntityVelocity(Packet28EntityVelocity packet28entityvelocity)
    {
        registerPacket(packet28entityvelocity);
    }

    public void handleEntityMetadata(Packet40EntityMetadata packet40entitymetadata)
    {
        registerPacket(packet40entitymetadata);
    }

    public void handleAttachEntity(Packet39AttachEntity packet39attachentity)
    {
        registerPacket(packet39attachentity);
    }

    public void handleUseEntity(Packet7UseEntity packet7useentity)
    {
        registerPacket(packet7useentity);
    }

    public void handleEntityStatus(Packet38EntityStatus packet38entitystatus)
    {
        registerPacket(packet38entitystatus);
    }

    public void handleHealth(Packet8UpdateHealth packet8updatehealth)
    {
        registerPacket(packet8updatehealth);
    }

    public void handleRespawn(Packet9Respawn packet9respawn)
    {
        registerPacket(packet9respawn);
    }

    public void handleExplosion(Packet60Explosion packet60explosion)
    {
        registerPacket(packet60explosion);
    }

    public void handleOpenWindow(Packet100OpenWindow packet100openwindow)
    {
        registerPacket(packet100openwindow);
    }

    public void handleCloseWindow(Packet101CloseWindow packet101closewindow)
    {
        registerPacket(packet101closewindow);
    }

    public void handleWindowClick(Packet102WindowClick packet102windowclick)
    {
        registerPacket(packet102windowclick);
    }

    public void handleSetSlot(Packet103SetSlot packet103setslot)
    {
        registerPacket(packet103setslot);
    }

    public void handleWindowItems(Packet104WindowItems packet104windowitems)
    {
        registerPacket(packet104windowitems);
    }

    public void handleUpdateSign(Packet130UpdateSign packet130updatesign)
    {
        registerPacket(packet130updatesign);
    }

    public void handleCraftingProgress(Packet105UpdateProgressbar packet105updateprogressbar)
    {
        registerPacket(packet105updateprogressbar);
    }

    public void handlePlayerInventory(Packet5PlayerInventory packet5playerinventory)
    {
        registerPacket(packet5playerinventory);
    }

    public void handleContainerTransaction(Packet106Transaction packet106transaction)
    {
        registerPacket(packet106transaction);
    }

    public void handleEntityPainting(Packet25EntityPainting packet25entitypainting)
    {
        registerPacket(packet25entitypainting);
    }

    public void handleNotePlay(Packet54PlayNoteBlock packet54playnoteblock)
    {
        registerPacket(packet54playnoteblock);
    }

    public void handleStatistic(Packet200Statistic packet200statistic)
    {
        registerPacket(packet200statistic);
    }

    public void handleSleep(Packet17Sleep packet17sleep)
    {
        registerPacket(packet17sleep);
    }

    public void handlePosition(Packet27Position packet27position)
    {
        registerPacket(packet27position);
    }

    public void handleBedUpdate(Packet70Bed packet70bed)
    {
        registerPacket(packet70bed);
    }

    public void handleWeather(Packet71Weather packet71weather)
    {
        registerPacket(packet71weather);
    }

    public void processItemData(Packet131MapData packet131mapdata)
    {
        registerPacket(packet131mapdata);
    }

    public void handleAuxSFX(Packet61DoorChange packet61doorchange)
    {
        registerPacket(packet61doorchange);
    }

    public void handleServerPing(Packet254ServerPing packet254serverping)
    {
        registerPacket(packet254serverping);
    }

    public void handleEntityEffect(Packet41EntityEffect packet41entityeffect)
    {
        registerPacket(packet41entityeffect);
    }

    public void handleRemoveEntityEffect(Packet42RemoveEntityEffect packet42removeentityeffect)
    {
        registerPacket(packet42removeentityeffect);
    }

    public void handlePlayerInfo(Packet201PlayerInfo packet201playerinfo)
    {
        registerPacket(packet201playerinfo);
    }

    public void handleKeepAlive(Packet0KeepAlive packet0keepalive)
    {
        registerPacket(packet0keepalive);
    }

    public void handleExperience(Packet43Experience packet43experience)
    {
        registerPacket(packet43experience);
    }

    public void handleCreativeSetSlot(Packet107CreativeSetSlot packet107creativesetslot)
    {
        registerPacket(packet107creativesetslot);
    }

    public void handleXPOrb(Packet26EntityExpOrb packet26entityexporb)
    {
        registerPacket(packet26entityexporb);
    }

    public void func_40599_a(Packet108EnchantItem packet108enchantitem)
    {
    }
}

package no.runsafe.cheeves.achievements;

        import no.runsafe.cheeves.Achievement;
        import no.runsafe.cheeves.AchievementHandler;
        import no.runsafe.cheeves.Achievements;
        import no.runsafe.framework.api.event.inventory.IInventoryClick;
        import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
        import no.runsafe.framework.api.player.IPlayer;
        import no.runsafe.framework.minecraft.Item;
        import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
        import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
        import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
        import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class FlintsGoldHoarder extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
    public FlintsGoldHoarder(AchievementHandler achievementHandler)
    {
        super(achievementHandler);
    }

    @Override
    public String getAchievementName()
    {
        return "Shinies be Mine!";
    }

    @Override
    public String getAchievementInfo()
    {
        return "Fish up all of the rare items at spawn.";
    }

    @Override
    public int getAchievementID()
    {
        return Achievements.SHINIES_BE_MINE.ordinal();
    }

    private void checkInventory (RunsafeInventory inventory, IPlayer player)
    {
        if (player.isInUniverse("survival"))
        {
            if (inventoryItem.is(Item.Decoration.Vine))
            {
                String displayName = inventoryItem.getDisplayName();
                if (displayName != null && displayName.equals("§Washed-up Seaweed"))
                {
                    amount += inventoryItem.getAmount();
                    if (amount >= 1)
                    {
                        award(player)
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
    {
        checkInventory(event.getInventory(), event.getWhoClicked());
    }

    @Override
    public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
    {
        IPlayer player = event.getPlayer();
        checkInventory(player.getInventory(), player);
    }
}
package module.training.ui.comp;

import core.gui.comp.entry.IHOTableEntry;
import core.model.player.Player;
import core.training.TrainingPreviewPlayers;

import javax.swing.*;

public class PlayerNameCell implements IHOTableEntry {

    private JLabel m_clComponent;
    private Player player;
    private int speed;

    public PlayerNameCell(Player player, int speed) {
        super();
        this.speed = speed;
        this.player = player;
        createComponent();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public JComponent getComponent(boolean isSelected) {
        return this.m_clComponent;
    }

    @Override
    public void clear() {

    }

    @Override
    public int compareTo(IHOTableEntry obj) {
        if (obj instanceof PlayerNameCell) {
            PlayerNameCell pnc = (PlayerNameCell) obj;

            if (this.getSpeed() > pnc.getSpeed()) {
                return -1;
            }

            if (this.getSpeed() < pnc.getSpeed()) {
                return 1;
            }
        }
        return 0;
    }

    public final int compareToThird(IHOTableEntry obj) {
        if (obj instanceof PlayerNameCell) {
            final PlayerNameCell entry = (PlayerNameCell) obj;
            int num1 = TrainingPreviewPlayers.instance().getTrainPreviewPlayer(player).getSortIndex();
            int num2 = TrainingPreviewPlayers.instance().getTrainPreviewPlayer(entry.player).getSortIndex();

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            } else {
                return entry.compareTo(this);
            }
        }
        return 0;
    }

    @Override
    public void createComponent() {
        m_clComponent = new JLabel();
        m_clComponent.setOpaque(true);
        m_clComponent.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
        m_clComponent.setText(player.getName());

        String tooltip = TrainingPreviewPlayers.instance().getTrainPreviewPlayer(player).getText();
        if (tooltip == null) {
            tooltip = "";
        }
        m_clComponent.setToolTipText(tooltip);
        m_clComponent.setIcon(TrainingPreviewPlayers.instance().getTrainPreviewPlayer(player).getIcon());
    }

    @Override
    public void updateComponent() {

    }
}

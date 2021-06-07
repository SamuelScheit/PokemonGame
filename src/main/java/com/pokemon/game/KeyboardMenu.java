package com.pokemon.game;
// @Litiengine: https://github.com/gurkenlabs/litiengine-ldjam44/blob/master/src/de/gurkenlabs/ldjam44/ui/KeyboardMenu.java

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.ImageScaleMode;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;

public class KeyboardMenu extends Menu {
    public static final Color BUTTON_RED = new Color(140, 16, 16, 200);
    public static final Color BUTTON_BLACK = new Color(0, 0, 0, 200);

    public static final int MENU_DELAY = 0;

    private final List<Consumer<Integer>> confirmConsumer;
    protected int currentFocus = -1;

    public static long lastMenuInput;

    public KeyboardMenu(double x, double y, double width, double height, String... items) {
        super(x, y, width, height, items);
        this.confirmConsumer = new CopyOnWriteArrayList<>();

        Input.keyboard().onKeyTyped(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (this.menuInputIsLocked()) return;

                this.confirm();
                lastMenuInput = Game.time().now();
            }
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_UP, e -> {
            if (this.menuInputIsLocked()) return;

            decFocus();
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_DOWN, e -> {
            if (this.menuInputIsLocked()) return;

            incFocus();
        });
    }

    private boolean menuInputIsLocked() {
        // disable menu if the game has started
        if (this.isSuspended() || !this.isVisible() || !this.isEnabled()) {
            return true;
        }

        return Game.time().since(lastMenuInput) < MENU_DELAY;
    }

    @Override
    public void prepare() {
        super.prepare();
        this.setForwardMouseEvents(false);
        this.getCellComponents().forEach(comp -> comp.setForwardMouseEvents(false));

        for (int i = 0; i < getCellComponents().size(); i++) {
            ImageComponent comp = getCellComponents().get(i);

            comp.getAppearance().setForeColor(Color.BLACK);
//            comp.getAppearance().setBackgroundColor1(BUTTON_BLACK);
//            comp.getAppearanceHovered().setBackgroundColor1(BUTTON_RED);
//            comp.getAppearance().setTransparentBackground(false);
//            comp.getAppearanceHovered().setTransparentBackground(false);
            comp.getAppearance().setBorderRadius(10);
            comp.getAppearanceHovered().setForeColor(Color.WHITE);
            comp.setImageScaleMode(ImageScaleMode.STRETCH);
            this.hoverMenuEntry(i, false);
        }

        if (!this.getCellComponents().isEmpty()) {
            this.currentFocus = 0;
            ImageComponent comp = getCellComponents().get(0);
            this.hoverMenuEntry(0, true);
        }
    }

    public void hoverMenuEntry(int i, boolean hovered) {
        ImageComponent comp = getCellComponents().get(i);
        comp.setHovered(hovered);

        if (hovered) {
            comp.setImage(Resources.images().get("assets/button/selected.png"));
        } else {
            comp.setImage(Resources.images().get("assets/button/unselected.png"));
        }
    }

    public void onConfirm(Consumer<Integer> cons) {
        this.confirmConsumer.add(cons);
    }

    private void confirm() {
        for (Consumer<Integer> cons : this.confirmConsumer) {
            cons.accept(this.currentFocus);
        }
    }

    protected void decFocus() {
        this.currentFocus = Math.floorMod(--this.currentFocus, this.getCellComponents().size());
        this.updateFocus();
    }

    protected void incFocus() {
        this.currentFocus = ++this.currentFocus % this.getCellComponents().size();
        this.updateFocus();
    }

    protected void updateFocus() {
        this.setCurrentSelection(this.currentFocus);
        for (int i = 0; i < this.getCellComponents().size(); i++) {
            ImageComponent comp = this.getCellComponents().get(i);
            boolean hovered = i == this.currentFocus;
            if (comp.isHovered() != hovered) {
                hoverMenuEntry(i, hovered);
            }
        }

        lastMenuInput = Game.time().now();
        }
    }

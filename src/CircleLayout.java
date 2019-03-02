package src;

import javax.swing.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

class CircleLayout implements LayoutManager {
    private double radiusFactor;
    private boolean sizeUnknown = true;
    private int preferredWidth = 0, preferredHeight = 0;

    public CircleLayout(double radiusFactor) {
        this.radiusFactor = radiusFactor;
    }

    public CircleLayout() {
        this(0.75);
    }

    public void layoutContainer(Container parent) {
        Component component;
        Dimension preferredSize;
        int componentCount = parent.getComponentCount();
        int centerX = getCenterX(parent);
        int centerY = getCenterY(parent);

        if (componentCount == 1) {
            component = parent.getComponent(0);
            preferredSize = component.getPreferredSize();
            component.setBounds(centerX, centerY, preferredSize.width, preferredSize.height);
        } else {
            double radius = getRadius(parent);
            for (int i = 0; i < componentCount; i++) {
                component = parent.getComponent(i);
                preferredSize = component.getPreferredSize();
                // ?
                component.setBounds(getComponentX(componentCount, i, centerX, radius) - preferredSize.width / 2,
                                    getComponentY(componentCount, i, centerY, radius) - preferredSize.height / 2,
                                    preferredSize.width,
                                    preferredSize.height);
            }
        }
    }

    private int getComponentX(int partsCount, int componentNumber, int centerX, double radius) {
        return (int) (radius * Math.cos(2 * componentNumber * Math.PI / partsCount)) + centerX;
    }

    private int getComponentY(int partsCount, int componentNumber, int centerY, double radius) {
        return (int) (radius * Math.sin(2 * componentNumber * Math.PI / partsCount)) + centerY;
    }

    private int getCenterX(Container parent) {
        Insets insets = parent.getInsets();
        return ((int) (parent.getSize().width - (insets.left + insets.right)) / 2) + insets.left;
    }

    private int getCenterY(Container parent) {
        Insets insets = parent.getInsets();
        return ((int) (parent.getSize().height - (insets.top + insets.bottom)) / 2) + insets.left;
    }


    private double getRadius(Container parent) {
        Insets insets = parent.getInsets();
        double parentWidth = parent.getSize().width;
        double parentHeight = parent.getSize().height;
        return (Math.min(parentWidth - (insets.left + insets.right),
                         parentHeight - (insets.top + insets.bottom)))
                / 2 * radiusFactor;
    }

    public Double getRadiusFactor() {
        return radiusFactor;
    }

    public void setRadiusFactor(double radiusFactor) {
        this.radiusFactor = radiusFactor;
    }

    public Dimension preferredLayoutSize(Container parent) {
        setSizes(parent);

        Insets insets = parent.getInsets();
        int width = preferredWidth + insets.left + insets.right;
        int height = preferredHeight + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    public Dimension minimumLayoutSize(Container parent) {
        return preferredLayoutSize(parent);
    }

    private void setSizes(Container parent) {
        if (!sizeUnknown) return;
        int componentCount = parent.getComponentCount();

        preferredWidth = 0;
        preferredHeight = 0;

        for (int componentNumber = 0; componentNumber < componentCount; componentNumber++)
        {
            Component component = parent.getComponent(componentNumber);
            Dimension size = component.getPreferredSize();
            preferredWidth += size.width;
            preferredHeight += size.height;
        }
        sizeUnknown = false;
    }


    public void addLayoutComponent(String name, Component component) {
    }

    public void removeLayoutComponent(Component component) {
    }

    public String toString() {
        return this.getClass().getName() + "[radiusFactor = " + radiusFactor + "]";
    }
}

package me.shaneyboy02.ducky.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.shaneyboy02.ducky.DuckMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class AdultDuck<T extends Entity> extends EntityModel<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DuckMod.MODID, "textures/entity/adult_duck.png");
    private final ModelPart Mallard;

    public AdultDuck(ModelPart root) {
        this.Mallard = root.getChild("Mallard");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Mallard = partdefinition.addOrReplaceChild("Mallard", CubeListBuilder.create().texOffs(1, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -1.0F));

        PartDefinition Head = Mallard.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 4).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

        PartDefinition LWing = Mallard.addOrReplaceChild("LWing", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -0.5F, -1.5F));

        PartDefinition RWing = Mallard.addOrReplaceChild("RWing", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -0.5F, -1.5F));

        PartDefinition LLeg = Mallard.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(8, 13).addBox(-0.5F, 1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.0F, 1.0F));

        PartDefinition RLeg = Mallard.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(17, 0).addBox(-1.5F, 1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 1.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static ResourceLocation getTexture() {
        return TEXTURE;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Mallard.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
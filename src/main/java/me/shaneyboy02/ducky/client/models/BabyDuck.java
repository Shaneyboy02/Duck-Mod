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

public class BabyDuck<T extends Entity> extends EntityModel<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DuckMod.MODID, "textures/entity/baby_duck.png");

    private final ModelPart Chick;

    public BabyDuck(ModelPart root) {
        this.Chick = root.getChild("Chick");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Chick = partdefinition.addOrReplaceChild("Chick", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 1.0F));

        PartDefinition Head = Chick.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(8, 6).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F))
                .texOffs(2, 6).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.5F));

        PartDefinition LWing = Chick.addOrReplaceChild("LWing", CubeListBuilder.create().texOffs(1, 7).addBox(0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, -1.0F));

        PartDefinition RWing = Chick.addOrReplaceChild("RWing", CubeListBuilder.create().texOffs(1, 7).addBox(0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.05F, -3.0F, -1.0F));

        PartDefinition LLeg = Chick.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.5F, 0.0F));

        PartDefinition RLeg = Chick.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    public static ResourceLocation getTexture() {
        return TEXTURE;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Chick.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
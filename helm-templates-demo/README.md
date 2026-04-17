# Helm Templates Demo

This example chart demonstrates the most useful Helm template patterns:

- `include` + helper templates (`_helpers.tpl`)
- `if` conditions (`ingress.enabled`, `autoscaling.enabled`)
- `with` blocks (`podAnnotations`, `ingress.annotations`)
- `range` loops (`env`, ingress hosts/paths)
- `default` fallback (`image.tag` fallback to `.Chart.AppVersion`)
- `toYaml` + `nindent` for safe YAML rendering

## Quick start

```bash
helm lint ./helm-templates-demo
helm template demo ./helm-templates-demo
```

## Useful experiments

Render without ingress and autoscaling:

```bash
helm template demo ./helm-templates-demo \
  --set ingress.enabled=false \
  --set autoscaling.enabled=false
```

Render with a custom image tag:

```bash
helm template demo ./helm-templates-demo --set image.tag=1.25.5
```

Render with extra environment variables:

```bash
helm template demo ./helm-templates-demo \
  --set env.LOG_LEVEL=debug \
  --set env.FEATURE_FLAG_X=false \
  --set env.NEW_FLAG=enabled
```
